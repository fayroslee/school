set logscale x 2
set logscale y 2

set xlabel "Problem Size(n)"
set ylabel "Average Runtime(ms)"

set key bottom right

set title 'Polynomial Multiplication'

set term png
set output 'polymult.png'

plot 'polymult.schoolbook' using 1:2 title 'School-Book' with linespoints, \
     'polymult.dnc4' using 1:2 title 'D&C 4 Subproblems' with linespoints, \
     'polymult.dnc3' using 1:2 title 'D&C 3 Subproblems' with linespoints;
