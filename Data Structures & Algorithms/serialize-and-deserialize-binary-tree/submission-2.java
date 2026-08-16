// Jai Ganesh
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> tree = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        if(root != null) {
            q.offer(root);
            tree.add(String.valueOf(root.val));
        }

        

        while(!q.isEmpty()) {
            TreeNode node = q.poll();

            if(node != null) {
                TreeNode left = node.left;
                TreeNode right = node.right;

                if(left == null) {
                    tree.add("null");
                }

                if(left != null) {
                    tree.add(String.valueOf(left.val));
                }

                if(right == null) {
                    tree.add("null");
                }

                if(right != null) {
                    tree.add(String.valueOf(right.val));
                }

                if(left != null) {
                    q.offer(left);
                }

                if(right != null) {
                    q.offer(right);
                }
            }
        }

        int firstOccurenceOfLeafNull = tree.size();
        
        for(int index = tree.size()-1; index >= 0; index--) {
            if(tree.get(index).equals("null")) {
                firstOccurenceOfLeafNull = index;
            }
            else {
                break;
            }
        }

        List<String> treeWithoutChildNulls = new ArrayList<>();

        for(int ind = 0; ind < firstOccurenceOfLeafNull; ind++) {
            treeWithoutChildNulls.add(tree.get(ind));
        }

        String str = treeWithoutChildNulls.stream()
                    .map(Objects::toString)
                    .collect(Collectors.joining(","));

        return str;
    }

    static int[] getChildIndex(int index) {
        return new int[]{2*index, 2*index + 1};
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) {
            return null;
        }    

        ArrayList<Integer> newList = Arrays.stream(data.split(","))
            .map(val -> "null".equals(val) ? null : Integer.valueOf(val))
            .collect(Collectors.toCollection(ArrayList::new));

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(newList.get(0));

        q.offer(root);
        int curr = 1;

        while(!q.isEmpty() && curr < newList.size()) {
            TreeNode node = q.poll();
            TreeNode leftChild = newList.get(curr) != null ? new TreeNode(newList.get(curr)) : null;
            node.left = leftChild;

            if(leftChild != null) {
                q.offer(leftChild);
            }
            curr++;

            if(curr < newList.size()) {
                TreeNode rightChild = newList.get(curr) != null ? new TreeNode(newList.get(curr)) : null;
                node.right = rightChild;

                if(rightChild != null) {
                    q.offer(rightChild);
                }
                curr++;                    
            }
        }

    return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));