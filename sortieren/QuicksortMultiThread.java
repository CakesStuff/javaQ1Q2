package sortieren;

import java.util.concurrent.CountDownLatch;

public class QuicksortMultiThread {
    public String[] quicksortArr(String[] strings) {
        CountDownLatch c = new CountDownLatch(1);
        new QuicksortThread(strings, 0, strings.length, c).start();
        try {
            c.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strings;
    }

    private class QuicksortThread extends Thread {
        private String[] strings;
        private int l;
        private int r;
        CountDownLatch c;

        public QuicksortThread(String[] strings, int l, int r, CountDownLatch c) {
            this.strings = strings;
            this.l = l;
            this.r = r;
            this.c = c;
        }

        @Override
        public void run() {
            if((r-l) < 2){
                c.countDown();
                return;
            }

            String pivot = strings[l];

            String[] parts = new String[r - l];
            int li = 0;
            int ri = r - l;

            for(int i = l + 1; i < r; i++) {
                if(strings[i].compareTo(pivot) < 0) {
                    parts[li++] = strings[i];
                } else {
                    parts[--ri] = strings[i];
                }
            }

            CountDownLatch c2 = new CountDownLatch(2);
            if(li < 10000) {
                quicksortArrRec(parts, 0, li);
                c2.countDown();
            } else {
                new QuicksortThread(parts, 0, li, c2).start();
            }
            if(r - l - ri < 10000) {
                quicksortArrRec(parts, ri, r - l);
                c2.countDown();
            } else {
                new QuicksortThread(parts, ri, r - l, c2).start();
            }

            try {
                c2.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.arraycopy(parts, 0, strings, l, li);//r - l);
            strings[li + l] = pivot;
            System.arraycopy(parts, ri, strings, ri + l, r - l - ri);

            c.countDown();
        }
    }

    private void quicksortArrRec(String[] strings, int l, int r) {
        if((r-l) < 2) return;

        String pivot = strings[l];

        String[] parts = new String[r - l];
        int li = 0;
        int ri = r - l;

        for(int i = l + 1; i < r; i++) {
            if(strings[i].compareTo(pivot) < 0) {
                parts[li++] = strings[i];
            } else {
                parts[--ri] = strings[i];
            }
        }

        quicksortArrRec(parts, 0, li);
        quicksortArrRec(parts, ri, r - l);

        System.arraycopy(parts, 0, strings, l, li);//r - l);
        strings[li + l] = pivot;
        System.arraycopy(parts, ri, strings, ri + l, r - l - ri);
    }
}
