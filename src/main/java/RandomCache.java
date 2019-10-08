
import java.util.Random;

public class RandomCache implements Cache {



    private Storage storage;
    private int size;
    private int hits;
    private int misses;
    private Random rnd = new Random();
    private Integer [] cache = new Integer[4];

    public int get (int e){
        for (int i = 0; i<cache.length; i++){
            if (e==cache[i]){
                hits++;
                return e;
            }

        }
        int element = storage.get (e);
        cache [rnd.nextInt(3)]=element;
        misses++;
        return element;
    }

    @Override
    public int getHits() {
        return hits;
    }

    public int getMisses(){
        return misses;
    }

    public Integer getCacheOrder(){
        for (int i = 0; i<cache.length; i++){
            return (Integer) cache [i];
        }

    }




    public RandomCache(int size) {
        this.storage = new Storage();
    }

}
