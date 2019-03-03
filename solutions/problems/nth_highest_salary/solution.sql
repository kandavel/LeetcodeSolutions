CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
 SET N = N-1;
  RETURN (
      # Write your MySQL query statement below.
     
      SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC LIMIT N, 1
  );
END

# CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
# BEGIN
#     set N=N-1;
#   RETURN (
#       select distinct Salary from Employee order by Salary desc limit N,1
#   );
# END