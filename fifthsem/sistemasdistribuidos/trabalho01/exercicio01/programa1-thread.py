import threading

global total_habit_nao_vacin
total_habit_nao_vacin = 350000

def aplica_vacina(param):
    global total_habit_nao_vacin
    
    for i in range(total_habit_nao_vacin+param):
        print('{} pessoa(s) nao vacinada(s)' .format(total_habit_nao_vacin-i))

def aumenta_imunizados(param):
    global total_habit_nao_vacin

    for i in range(total_habit_nao_vacin+param):
        print('{} pessoa(s) imunizada(s)' .format(i))


if __name__ == '__main__':
    t1 = threading.Thread(target=aplica_vacina, args=(1, ))
    t2 = threading.Thread(target=aumenta_imunizados, args=(1, ))

    t1.start()
    t2.start()

    t1.join()
    t2.join()