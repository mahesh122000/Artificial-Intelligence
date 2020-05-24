import pandas as pd
import numpy as np
for i in range(int(input())):
    j=int(input())
    df=pd.DataFrame(np.array([input().split() for _ in range(6)],float).T)
    print(df.corr('kendall')[0][1:].argmax())
