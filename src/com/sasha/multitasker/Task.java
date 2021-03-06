package com.sasha.multitasker;

public class Task implements Runnable {

    private Runnable task;
    @Deprecated //todo
    private long delay = 0L;
    protected boolean async = false;

    public Task(Runnable runnable) {
        this.task = runnable;
    }

    @Deprecated //todo
    public Task(Runnable runnable, long delay) {
        this.task = runnable;
        if (delay < 0L) throw new IllegalArgumentException("You tried to set the delay to a negative number!");
        this.delay = delay;
    }

    @Override
    public void run() {
        if (task != null) task.run();
    }
}
