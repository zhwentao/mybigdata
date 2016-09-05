package obj;

public class ObjItem {
    public static boolean gcrun = false;
    public static boolean f = false;
    public static int created = 0;
    public static int finalized = 0;
    public int i;

    static {
        gcrun = f = false;
        finalized = created = 0;
    }

    public ObjItem() {
        this.i = created++;
        if (i == 37) {
            System.out.println("created 37");
        }
    }

    public void finalize() {
        if (!gcrun) {
            gcrun = true;
            System.out.println("GC run after crearted " + created + " objitems!");
        }

        if (this.i == 37) {
            System.out.println("Finalize #37, stop Create obj item!");
            f = true;
        }
        finalized++;
        if (finalized >= created) {
            System.out.println("All " + finalized + " Finalized!");
        }
    }
}
