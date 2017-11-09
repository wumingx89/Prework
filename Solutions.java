public class Solutions {
    // Checkpoint 1
    // O(n)

    // Checkpoint 2
    public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int size = 2 * a - 1;
        int[][] temp = new int[size][size];
        for (int i = 0; i < a; i++) {
            int r = i;
            int c = i;
            int current = a - i;

            // top row
            while (c < size - i) {
                temp[r][c++] = current;
            }
            c--;

            // right col
            while (r < size - i) {
                temp[r++][c] = current;
            }
            r--;

            // bottom row
            while (c >= i) {
                temp[r][c--] = current;
            }
            c++;

            // left col
            while (r >= i) {
                temp[r--][c] = current;
            }
        }

        for (int i = 0; i < size; i++) {
            ArrayList<Integer> current = new ArrayList<>(size);
            for (int j = 0; j < size; j++) {
                current.add(temp[i][j]);
            }
            result.add(current);
        }

        return result;
    }

    // Checkpoint 3-1
    public int kthsmallest(final List<Integer> a, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (Integer i : a) {
            maxHeap.offer(i);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return maxHeap.poll();
    }

    // Checkpoint 3-2
    public int numRange(ArrayList<Integer> a, int b, int c) {
        int result = 0;
        int sum = 0;
        int i = 0;
        int j = 0;
        while (i < a.size()) {
            sum += a.get(j);
            if (sum >= b && sum <= c) {
                result++;
                j++;
            } else if (sum < b) {
                j++;
            }

            if (sum > c || j == a.size()) {
                i++;
                j = i;
                sum = 0;
            }
        }

        return result;
    }

    // Checkpoint 4
    public ListNode subtract(ListNode a) {
        ListNode temp = a;
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        temp = a;
        int size =  stack.size() / 2;
        for (int i = 0; i < size; i++) {
            temp.val = stack.pop() - temp.val;
            temp = temp.next;
        }

        return a;
    }

    // Checkpoint 5
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (a.isEmpty()) {
            result.add(new ArrayList<>());
            return result;
        }

        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < a.size(); i++) {
            Integer current = a.get(i);
            if (used.contains(current)) {
                continue;
            }

            ArrayList<Integer> subset = new ArrayList<>(a.size() - 1);
            for (int j = 0; j < a.size(); j++) {
                if (j != i) {
                    subset.add(a.get(j));
                }
            }
            ArrayList<ArrayList<Integer>> temp = permute(subset);

            for (ArrayList<Integer> list : temp) {
                list.add(0, current);
                result.add(list);
            }
            used.add(current);
        }

        return result;
    }
}
