import multiprocessing

global total_habit_nao_vacin
total_habit_nao_vacin = multiprocessing.Value('L', 0)
total_habit_nao_vacin.value = 350000

def aplica_vacina(param):
    global total_habit_nao_vacin
    
    for i in range(total_habit_nao_vacin.value+param):
        print('{} pessoa(s) nao vacinada(s)' .format(total_habit_nao_vacin.value-i))

def aumenta_imunizados(param):
    global total_habit_nao_vacin

    for i in range(total_habit_nao_vacin.value+param):
        print('{} pessoa(s) imunizada(s)' .format(i))


if __name__ == '__main__':
    p1 = multiprocessing.Process(target=aplica_vacina, args=(1, ))
    p2 = multiprocessing.Process(target=aumenta_imunizados, args=(1, ))

    p1.start()
    p2.start()

    p1.join()
    p2.join()