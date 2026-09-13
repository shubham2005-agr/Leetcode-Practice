class Solution {
public:
    int largestOverlap(vector<vector<int>>& img1,
                       vector<vector<int>>& img2) {
        
        int n = img1.size();

        vector<pair<int, int>> ones1, ones2;

        // Store coordinates of all 1s
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1)
                    ones1.push_back({i, j});

                if (img2[i][j] == 1)
                    ones2.push_back({i, j});
            }
        }

        unordered_map<string, int> count;
        int ans = 0;

        // Try every possible relative shift
        for (auto [r1, c1] : ones1) {
            for (auto [r2, c2] : ones2) {
                int dr = r2 - r1;
                int dc = c2 - c1;

                string key = to_string(dr) + "," + to_string(dc);

                count[key]++;
                ans = max(ans, count[key]);
            }
        }

        return ans;
    }
};
