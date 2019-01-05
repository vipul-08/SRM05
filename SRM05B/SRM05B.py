import re
t = int(input())
ans = []
for i in range(0,t):
    ans.append("invalid")
    ip = input()
    if "." in ip:
        parts = ip.split(".")
        if len(parts) == 4:
            for j in range(0,len(parts)):
                if len(parts[j]) == 0:
                    ans[i] = "invalid"
                    break
                else:
                    if parts[j][0] == '0':
                        if len(parts[j]) == 1:
                            if j < 3:
                                continue
                            elif j == 3:
                                ans[i] = "ipv4"
                        else:
                            ans[i] = "invalid"
                            break
                    if parts[j].isnumeric() and len(parts[j]) <= 3:
                        temp = int(parts[j])
                        if temp >=0 and temp<=255:
                            if j < 3:
                                continue
                            elif j == 3:
                                ans[i] = "ipv4"
                        else:
                            ans[i] = "invalid"
                            break
                    else:
                        ans[i] = "invalid"
                        break
        else:
            ans[i] = "invalid"
    elif ":" in ip:
        parts = ip.split(":")
        if len(parts) == 8:
            for j in range(0,len(parts)):
                if parts[j][0] == '0':
                    if len(parts[j]) == 1:
                        if j < 7:
                            continue
                        elif j == 7:
                            ans[i] = "ipv6"
                    else:
                        ans[i] = "invalid"
                        break
                if bool(re.match('^[a-f0-9]+$', parts[j])) == True and len(parts[j]) <= 4:
                    if j < 7:
                        continue
                    elif j == 7:
                        ans[i] = "ipv6"
                else:
                    ans[i] = "invalid"
                    break
        else:
            ans[i] = "invalid"
    else:
        ans[i] = "invalid"
for i in ans:
    print(i)