class Solution {
    public double average(int[] salary) {
    int minSalary = salary[0];
    int maxSalary = salary[0];
    double sum = 0.0;
    
    for (int i = 0; i < salary.length; i++) {
        if (salary[i] < minSalary) {
            minSalary = salary[i];
        }
        if (salary[i] > maxSalary) {
            maxSalary = salary[i];
        }
        sum += salary[i];
    }
    
    return (sum - minSalary - maxSalary) / (salary.length - 2);
    }
}