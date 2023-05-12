global total_habit_nao_vacin
total_habit_nao_vacin = 350000

def aplica_vacina():
    global total_habit_nao_vacin
    
    for i in range(total_habit_nao_vacin+1):
        print('{} pessoa(s) nao vacinada(s)' .format(total_habit_nao_vacin-i))

def aumenta_imunizados():
    global total_habit_nao_vacin

    for i in range(total_habit_nao_vacin+1):
        print('{} pessoa(s) imunizada(s)' .format(i))

if __name__ == '__main__':
    aplica_vacina()
    aumenta_imunizados()