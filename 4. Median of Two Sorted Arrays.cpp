    class Solution {
    public:
        double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
            nums1.insert(nums1.end(), nums2.begin(), nums2.end());
            sort(nums1.begin(), nums1.end());
            int len = nums1.size();
            double d = nums1[(nums1.size()/2)];
            if(len%2 != 0)
                return d;
            else {
                double d1 = nums1[ ((nums1.size() / 2)-1) ];
                d += d1;
                return double(d/2);

            }
        }      
    };