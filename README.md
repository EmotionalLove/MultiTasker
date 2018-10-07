# MultiTasker
A simple Library for scheduling tasks on different threads from other threads.

## How to use
Import TaskManager.jar as a library to your project.

In your main class, create a global Taskmanager field:

```Java
public class MyMainClass {
  // other fields
  public static TaskManager TASK_MANAGER = new TaskManager();
```

In your main function, call `TASK_MANAGER.tick();`

```Java
public class MyMainClass {
  //
  public static void main(String[] args) {
    new MyMainClass().start(args);
    // whatever other non-blocking tasks.
    TASK_MANAGER.tick();
  }
```
The `tick();` function WILL indefinetly block anything below from being called, so make sure it's the last thing getting called in your main function.

## Scheduling tasks

You can schedule tasks from any thread to either be executed on a seperate new thread, or on the thread you're calling `tick()` on.

In the above example, `tick()` is occuring on the `main` thread.

```Java
public class SomeWeirdClass extends SomeWeirdSuperclass {
  public synchronised void doSomethingSpooky(SpookyObject obj) {
    new Thread(() -> {
      System.out.println(obj.getSpookyName);
      MyMainClass.TASK_MANAGER.queueTask(new Task(() -> obj.doSpookyBigTask(), false);
    }).start();
  }
}
```

Use `queueTask(Task, boolean)` to queue tasks, as seen above. Setting the boolean to true will cause the task to run on it's own thread, and false will do otherwise.

This is by no means a complex library at all, it's simple, cute, and easy :)
