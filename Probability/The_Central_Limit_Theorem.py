import math
def cdf(x, mu, sigma):
    return 0.5 + math.erf((x-mu)/(sigma*2**0.5))*0.5

mu = 50000
sigma = 10000

weeks=11
start = 74000
weekly = 47000
end = start + weekly*weeks
lower_bound = end - 20000

sum_mu = weeks*mu
sum_sigma = weeks**0.5*sigma

print('{:0.4f}'.format(1-cdf(lower_bound, sum_mu, sum_sigma)))