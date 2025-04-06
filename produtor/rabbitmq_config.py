import pika
import os

def get_channel():
    url = os.environ.get(
        'CLOUDAMQP_URL',
        'amqps://phlrrzpz:1xEQQSDQ3G0oPJfR-kZSzikWdwREWKG_@jackal-01.rmq.cloudamqp.com/phlrrzpz'
    )
    params = pika.URLParameters(url)
    connection = pika.BlockingConnection(params)
    channel = connection.channel()
    channel.exchange_declare(exchange='topic-exchange', exchange_type='topic', durable=True)
    return connection, channel