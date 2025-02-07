class SubsetsSolution {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        // recurse(nums, 0, new ArrayList<>());
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    // recurse solution
    private void recurse(int[] nums, int index, List<Integer> path) {
        if (index == nums.length) {
            result.add(path);
            return;
        }
        // don't pick case
        recurse(nums, index + 1, new ArrayList<>(path));
        // pick case
        path.add(nums[index]);
        recurse(nums, index + 1, new ArrayList<>(path));

    }

    // backtrack solution
    private void backtrack(int[] nums, int index, List<Integer> path) {
        if (index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        backtrack(nums, index + 1, path);
        // step1:action
        path.add(nums[index]);
        // step2:recurse
        backtrack(nums, index + 1, path);
        // step3:backtrack - undo step1
        path.remove(path.size() - 1);
    }
}