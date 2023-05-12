import json

import flask
import requests

app = flask.Flask(__name__)


@app.route('/consumidor/<cep>', methods=['GET'])
def home(cep):
    response = requests.get(f"http://127.0.0.2:5000/chama-api/{cep}")
    jsonified = json.loads(response.text)
    return jsonified


if __name__ == '__main__':
    app.run(host='127.0.0.1')
