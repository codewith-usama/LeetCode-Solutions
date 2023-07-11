/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
// The following block might slightly improve the execution time;
// Can be removed;
static const auto __optimize__ = []() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    return 0;
}();

// Most of headers are already included;
// Can be removed;
#include <cstdint>
#include <vector>
#include <unordered_map>
#include <unordered_set>

using ValueType = int;

static const struct Solution {
        const std::vector<ValueType> distanceK(
            TreeNode* root,
            TreeNode* target,
            ValueType K
        ) {
            getParent(root);
            depthFirstSearch(target, K);
            return res;
        }

    private:
        std::vector<ValueType> res;
        std::unordered_map<TreeNode*, TreeNode*> parents;
        std::unordered_set<TreeNode*> visited;

        const void getParent(
            TreeNode* node
        ) {
            if (!node) {
                return;
            }

            if (node->left) {
                parents[node->left] = node;
                getParent(node->left);
            }

            if (node->right) {
                parents[node->right] = node;
                getParent(node->right);
            }
        }



        const void depthFirstSearch(
            TreeNode* node,
            const ValueType K
        ) {
            if (!node) {
                return;
            }

            if (visited.count(node) > 0) {
                return;
            }

            visited.insert(node);

            if (!K) {
                res.emplace_back(node->val);
                return;
            }

            depthFirstSearch(node->left, K - 1);
            depthFirstSearch(node->right, K - 1);
            depthFirstSearch(parents[node], K - 1);
        }
};