from suds.client import Client

hello_client = Client('http://localhost:7789/?wsdl')

cep = input('Insira o CEP: ')
print(hello_client.service.say_hello(cep))
