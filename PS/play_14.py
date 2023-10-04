# s = list(input())
# s.sort()

# alpha = ''
# digit = 0

# for val in s:
#     if val.isalpha():
#         alpha += val
#     elif val.isdigit():
#         digit += int(val)

# print(alpha + str(digit))


s = input()
result = []
value = 0

for x in s:
    if x.isalpha():
        result.append(x)
    elif x.isdigit():
        value += int(x)

result.sort()

if value != 0:
    result.append(str(value))

print(''.join(result))