package com.gexingw.concurrent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CompletableFutureExample {


    public static void main(String[] args) {


        ExecutorService executor = Executors.newFixedThreadPool(2);
        try {
            List<Order> orders = IntStream.rangeClosed(1, 10)
                    .mapToObj(i -> new Order((long) i))
                    .collect(Collectors.toList());

            // 原来的方法
            System.out.printf("方法1 start time: %s%n", currentTime());
            LinkedHashMap<Future<OrderResult>, Order> legacyMap = new LinkedHashMap<>();
            for (Order order : orders) {
                Future<OrderResult> future = executor.submit(() -> processOrder(order));
                legacyMap.put(future, order);
            }

            legacyMap.forEach((future, order) -> {
                try {
                    OrderResult result = future.get();
                    System.out.printf("legacy time: %s, order: %s, result: %s%n",
                            currentTime(), result.getOrder(), result.getStatus());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.printf("legacy time: %s, order: %s, error: 任务被中断%n", currentTime(), order);
                } catch (ExecutionException e) {
                    System.err.printf("legacy time: %s, order: %s, error: %s%n",
                            currentTime(), order, e.getCause() != null ? e.getCause().getMessage() : e.getMessage());
                }
            });
            System.out.printf("方法1 end time: %s%n", currentTime());


            // 使用Stream的方式
            System.out.printf("方法2 start time: %s%n", currentTime());

            // allOf 把多个 CompletableFuture 聚合成一个，join 等待全部任务完成
            // 收集所有异步任务句柄，方便统一等待
            CompletableFuture
                    .allOf(orders.stream()
                            // 为每个订单启动异步处理任务，返回 CompletableFuture<OrderResult>
                            .map(order -> CompletableFuture.supplyAsync(() -> processOrder(order), executor)
                                    // thenAccept 在同一条流水线上消费成功结果，这里打印订单处理状态
                                    .thenAccept(result -> System.out.printf("time: %s, order: %s, result: %s%n",
                                            currentTime(), result.getOrder(), result.getStatus()))
                                    // exceptionally 兜底处理异常，保证单个任务失败不会影响整体流程
                                    .exceptionally(throwable -> {
                                        System.err.printf("time: %s, order: %s, error: %s%n",
                                                currentTime(), order, throwable.getMessage());
                                        return null;
                                    })).toArray(CompletableFuture[]::new))
                    .join();
            System.out.printf("方法2 end time: %s%n", currentTime());

            // 不使用stream的方式
            System.out.printf("方法3 start time: %s%n", currentTime());
            List<CompletableFuture<Void>> manualFutures = new java.util.ArrayList<>();
            for (Order order : orders) {
                CompletableFuture<Void> future = CompletableFuture
                        .supplyAsync(() -> processOrder(order), executor)
                        .thenAccept(result -> System.out.printf("manual time: %s, order: %s, result: %s%n",
                                currentTime(), result.getOrder(), result.getStatus()))
                        .exceptionally(throwable -> {
                            System.err.printf("manual time: %s, order: %s, error: %s%n",
                                    currentTime(), order, throwable.getMessage());
                            return null;
                        });
                manualFutures.add(future);
            }

            CompletableFuture<Void>[] manualFuturesArray = manualFutures.toArray(new CompletableFuture[0]);
            CompletableFuture
                    .allOf(manualFuturesArray)
                    .join();

            for (CompletableFuture<Void> future : manualFutures) {
                future.join();
            }
            System.out.printf("方法3 end time: %s%n", currentTime());

            System.out.printf("end time: %s%n", currentTime());
        } finally {
            executor.shutdown();
            try {
                if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * 获取当前时、分、秒
     */
    public static String currentTime() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
    }

    public static OrderResult processOrder(Order order) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("任务被中断", e);
        }

        int status = order.getId() % 2 == 0 ? 0 : 1;
        return new OrderResult(order, status);
    }

    @Data
    @Accessors(chain = true)
    @AllArgsConstructor
    public static class Order {

        private Long id;

    }

    @Data
    @AllArgsConstructor
    public static class OrderResult {

        private Order order;

        private int status;

    }

}
