// Java code illustrating activeCount() method
import java.lang.*;
class NewThread extends Thread
{
    NewThread(String threadname, ThreadGroup tgob)
    {
        super(tgob, threadname);
        start();
    }
    public void run()
    {

        for (int i = 0; i < 1000; i++)
        {
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException ex)
            {
                System.out.println("Exception encounterted");
            }
        }
        System.out.println(Thread.currentThread().getName() +
                " finished executing");
    }
}
class ThreadGroupDemo
{
    public static void main(String arg[]) throws InterruptedException {
        // creating the thread group
        ThreadGroup gfg = new ThreadGroup("parent thread group");
        ThreadGroup gfg_child = new ThreadGroup(gfg, "child");
        NewThread t1 = new NewThread("one", gfg);
        System.out.println("Starting one");
        NewThread t2 = new NewThread("two", gfg);
        System.out.println("Starting two");

        // checking the number of active thread
        System.out.println("number of active thread: "
                + gfg.activeCount());
        System.out.println("number of active thread group: "
                + gfg.activeGroupCount());

        gfg.checkAccess();
        System.out.println(gfg.getName() + " has access");
        gfg_child.checkAccess();
        System.out.println(gfg_child.getName() + " has access");
        System.out.println("Maximum priority of ParentThreadGroup = "
                + gfg.getMaxPriority());
        System.out.println("t1 name" +  t1.getName());
        System.out.println("gfg name" +  gfg.getName());
        System.out.println("ParentThreadGroup for " + gfg.getName() +
                " is " + gfg.getParent().getName());
        System.out.println("ParentThreadGroup for " + gfg_child.getName()
                + " is " + gfg_child.getParent().getName());
        gfg.setDaemon(true);
        if (gfg.isDaemon() == true)
            System.out.println("Group is Daemon group");
        else
            System.out.println("Group is not Daemon group");
        System.out.println("String equivalent: " + gfg.toString());
        gfg.setMaxPriority(Thread.MAX_PRIORITY - 2);
        gfg_child.setMaxPriority(Thread.NORM_PRIORITY);
        gfg.list();
        if (gfg.parentOf(gfg_child))
            System.out.println(gfg.getName() + " is parent of " +
                    gfg_child.getName());
        // interrupting thread group
        gfg.interrupt();

        NewThread t3 = new NewThread("oneee", gfg_child);
        Thread[] group = new Thread[gfg.activeCount()];
        int count = gfg.enumerate(group);
        for (int i = 0; i < count; i++)
        {
            System.out.println("Thread " + group[i].getName() + " found");
        }

        Thread[] group1 = new Thread[gfg.activeCount()];
        int count1 = gfg.enumerate(group1, false);
        for (int i = 0; i < count1; i++)
        {
            System.out.println("Thread " + group1[i].getName() + " found");
        }
        ThreadGroup gfg_child_child = new ThreadGroup(gfg_child, "child_child");
        ThreadGroup[] group2 = new ThreadGroup[gfg.activeGroupCount()];
        int count2 = gfg.enumerate(group2);
        for (int i = 0; i < count2; i++)
        {
            System.out.println("ThreadGroup " + group2[i].getName() +
                    " found");
        }
        ThreadGroup[] group3 = new ThreadGroup[gfg.activeGroupCount()];
        int count3 = gfg.enumerate(group3,false);
        for (int i = 0; i < count3; i++)
        {
            System.out.println("ThreadGroup " + group3[i].getName() +
                    " found");
        }
        t3.join();
        gfg_child.destroy();
        System.out.println(gfg_child.getName() + " destroyed");
        if (gfg_child.isDestroyed() == true)
            System.out.println("Group is destroyed");
        else
            System.out.println("Group is not destroyed");
    }

}
