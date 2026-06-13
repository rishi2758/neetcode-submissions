class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] adjList = new List[numCourses];
        for (int[] prereq: prerequisites) {
            if (adjList[prereq[0]] == null) {
                adjList[prereq[0]] = new ArrayList<Integer>();
            }
            adjList[prereq[0]].add(prereq[1]);
        }

        int[] visited = new int[numCourses];
        for (int course = 0; course < numCourses; course++) {
            if(!dfs(course, adjList, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course, List<Integer>[] adjList, int[] visited) {
        if (adjList[course] == null) return true;
        if (visited[course] == 1) return false;
        if (visited[course] == 2) return true;

        visited[course] = 1;

        for (int prereq : adjList[course]) {
            if(!dfs(prereq, adjList, visited)) return false;
        }

        visited[course] = 2;
        return true;
    }
}
