from math import factorial, exp

def poisson(mean,k):
    return mean**k * exp(-mean) / factorial(k)

mean = 3
print "%.3f" % poisson(mean,0)
print "%.3f" %  (1 - poisson(mean,0)*poisson(mean,0) - poisson(mean,0)*poisson(mean,1) - poisson(mean,1)*poisson(mean,0))