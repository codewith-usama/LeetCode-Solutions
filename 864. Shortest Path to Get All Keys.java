class Solution {
    private int m;
    private int n;

    public int shortestPathAllKeys(String[] stringGrid) {
        m = stringGrid.length;
        n = stringGrid[0].length();
        char[][] grid = new char[m][n];
        int index = 0;
        for (String s : stringGrid) {
            grid[index++] = s.toCharArray();
        }
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '@') {
                    q.add(new int[] {i, j, 0});
                }
                if ('a' <= grid[i][j] && grid[i][j] <= 'f') {
                    count++;
                }
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int target = (1 << count) - 1;
        boolean[][][] visited = new boolean[m][n][target + 1];
        visited[q.peek()[0]][q.peek()[1]][0] = true;
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (--size >= 0) {
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                int state = curr[2];
                
                if (state == target) {
                    return steps;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    int nState = state;
                    if (!inBounds(nx, ny) || grid[nx][ny] == '#') {
                        continue;
                    }
                    if ('a' <= grid[nx][ny] && grid[nx][ny] <= 'f') {
                     
                        nState = state | (1 << (grid[nx][ny] - 'a'));
                    }
                    if (('A' > grid[nx][ny]
                                    || grid[nx][ny] > 'F'
                                    || ((nState & (1 << (grid[nx][ny] - 'A'))) != 0))
                            && !visited[nx][ny][nState]) {
                        q.add(new int[] {nx, ny, nState});
                        visited[nx][ny][nState] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private boolean inBounds(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}