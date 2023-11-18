
indicator = dict({
        'R':0, 'T':0, 'C':0, 'F':0, 'J':0, 'M':0, 'A':0, 'N':0
    })

type = list(indicator.keys())

def solution(survey, choices):
    answer = ''

    for i in range(len(survey)):
        is_nagative_choices(choices[i], survey[i])
        is_positive_choices(choices[i], survey[i])

    for i in range(0, len(type), 2):
        answer += is_type_test_generator(type[i], type[i+1])

    return answer


def is_type_test_generator(left_type, right_type):
    if (indicator[left_type] > indicator[right_type]):
        return left_type
    if (indicator[left_type] < indicator[right_type]):
        return right_type
    if (indicator[left_type] == indicator[right_type]):
        return min(left_type, right_type)

def is_nagative_choices(select_number, individual):
    if select_number == 1:
        indicator[individual[0]] += 3
    if select_number == 2:
        indicator[individual[0]] += 2
    if select_number == 3:
        indicator[individual[0]] += 1

def is_positive_choices(select_number, individual):
    if select_number == 5:
        indicator[individual[1]] += 1
    if select_number == 6:
        indicator[individual[1]] += 2
    if select_number == 7:
        indicator[individual[1]] += 3
    
def is_normal_choices(select_number, individual):
    if select_number == 4:
        return
    
survey = ["AN", "CF", "MJ", "RT", "NA"]
choices = [5, 3, 2, 7, 5]

print(solution(survey,choices))