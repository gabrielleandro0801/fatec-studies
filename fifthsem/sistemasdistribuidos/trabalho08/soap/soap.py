import json
import logging
from wsgiref.simple_server import make_server
import requests
from spyne import Unicode
from spyne.application import Application
from spyne.decorator import srpc
from spyne.model.complex import Iterable
from spyne.model.primitive import String
from spyne.protocol.soap import Soap11
from spyne.server.wsgi import WsgiApplication
from spyne.service import ServiceBase


class HelloWorldService(ServiceBase):

    @srpc(String, _returns=Iterable(Unicode))
    def say_hello(cep):
        response = requests.get(f"https://viacep.com.br/ws/{cep}/json/")
        data = json.loads(response.text)
        for item in data:
            yield f'{item}: {data[item]}'


if __name__ == '__main__':
    logging.basicConfig(level=logging.DEBUG)
    logging.getLogger('spyne.protocol.xml').setLevel(logging.DEBUG)

    app = Application([HelloWorldService],
                      'spyne.examples.hello.http',
                      in_protocol=Soap11(validator='lxml'),
                      out_protocol=Soap11())

    wsgi_app = WsgiApplication(app)
    server = make_server('127.0.0.1', 7789, wsgi_app)

    print("listening to http://127.0.0.1:7789")
    print("wsdl is at: http://localhost:7789/?wsdl")

    server.serve_forever()
