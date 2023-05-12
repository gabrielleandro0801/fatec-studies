from flask import Flask
from flask_restful import Api
from suds.client import Client

hello_client = Client('http://localhost:7789/?wsdl')
app = Flask(__name__)
api = Api(app)


@app.route('/chama-soap/<cep>', methods=['GET'])
def get(cep):
    return hello_client.service.say_hello(cep)


if __name__ == '__main__':
    app.run()
