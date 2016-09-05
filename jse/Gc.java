import obj.*;

public class Gc {
    public static void main(String args[]) {
        if (args.length == 0) {
            System.err.println("Usage: \n" +
                    "java Gc before\n or:\n" +
                    "java Gc after");
            return;
        }
        ObjItem arrayItems[] = new ObjItem[100];
        while (!ObjItem.f) {
            arrayItems[ObjItem.created%100] = new ObjItem();
            new String("To take up space");
        }
        System.out.println("Total created:" + ObjItem.created + "\t finalized:" +ObjItem.finalized);
        if (args[0].equals("before")) {
            System.out.println("gc:");
            System.gc();
            System.out.println("runFinalization");
            System.runFinalization();
        }
        System.out.println("finish!");
        if (args[0].equals("after")) {
            System.out.println("System.runFinalizersOnExit(true);");
            System.runFinalizersOnExit(true);
        }
    }
}
