import json

import flask
import requests

app = flask.Flask(__name__)


@app.route('/chama-api/<cep>', methods=['GET'])
def home(cep):
    response = requests.get(f"https://viacep.com.br/ws/{cep}/json/")
    jsonified = json.loads(response.text)
    print(jsonified)
    return jsonified


if __name__ == '__main__':
    app.run(host='127.0.0.2')
