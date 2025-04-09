# publish.py
import pika
import os
from datetime import datetime

# Configuração da conexão com o RabbitMQ
url = os.environ.get('CLOUDAMQP_URL', 'amqps://phlrrzpz:1xEQQSDQ3G0oPJfR-kZSzikWdwREWKG_@jackal-01.rmq.cloudamqp.com/phlrrzpz')
params = pika.URLParameters(url)
connection = pika.BlockingConnection(params)
channel = connection.channel()

# Declaração do exchange
channel.exchange_declare(exchange='topic-exchange', exchange_type='topic', durable=True)

def enviar_novidade():
    nome_evento = input('Digite o nome do evento: ')
    data_evento = input('Digite a data do evento (DD/MM/AAAA): ')
    horario_evento = input('Digite o horário do evento (HH:MM): ')
    local_evento = input('Digite o local do evento: ')
    atracao_principal = input('Digite a atração principal: ')
    link_ingressos = input('Digite o link para compra de ingressos: ')
    
    mensagem = f"Temos uma novidade para você! Chegou o evento {nome_evento}!\n" + \
               f"Data: {data_evento}\n" + \
               f"Horário: {horario_evento}\n" + \
               f"Local: {local_evento}\n" + \
               f"Atração principal: {atracao_principal}\n\n" + \
               f"Ingressos disponíveis! Não perca a chance de participar. Garanta o seu ingresso agora em: {link_ingressos}\n\n" + \
               "Nos vemos lá! 🎶\n" + \
               "Com amor, Sympla – Seu guia para eventos incríveis!"
    
    # Enviando para todos os consumidores
    channel.basic_publish(exchange='topic-exchange',
                         routing_key='novidade',
                         body=mensagem)
    print(f" [Mensagem de Novidade] Enviada -> <{mensagem}>")

def enviar_alerta():
    nome_evento = input('Digite o nome do evento: ')
    horas_restantes = input('Digite quantas horas faltam para o evento: ')
    data_evento = input('Digite a data do evento (DD/MM/AAAA): ')
    horario_evento = input('Digite o horário do evento (HH:MM): ')
    local_evento = input('Digite o local do evento: ')
    genero = input('Digite o gênero do evento (rock/pop/rap): ').lower()
    
    mensagem = f"Lembrete: o evento {nome_evento} começa em {horas_restantes} horas!\n" + \
               f"Data: {data_evento}\n" + \
               f"Horário: {horario_evento}\n" + \
               f"Local: {local_evento}\n\n" + \
               "Prepare-se para curtir esse evento incrível! 🎶\n" + \
               "Nos vemos lá!\n" + \
               "Com amor, Sympla – Seu guia para eventos incríveis!"
    
    # Enviando apenas para os consumidores do gênero específico
    channel.basic_publish(exchange='topic-exchange',
                         routing_key=f'informacao.{genero}',
                         body=mensagem)
    print(f" [Mensagem de Alerta] Enviada -> <{mensagem}>")

def enviar_mudanca():
    nome_evento = input('Digite o nome do evento: ')
    nova_data_evento = input('Digite a nova data do evento (DD/MM/AAAA): ')
    novo_horario_evento = input('Digite o novo horário do evento (HH:MM): ')
    local_evento = input('Digite o local do evento: ')
    genero = input('Digite o gênero do evento (rock/pop/rap): ').lower()
    
    mensagem = f"Atenção! O evento {nome_evento} sofreu uma alteração.\n" + \
               f"Nova Data: {nova_data_evento}\n" + \
               f"Novo Horário: {novo_horario_evento}\n" + \
               f"Local: {local_evento}\n\n" + \
               "Certifique-se de ajustar sua agenda para o novo horário e data!\n\n" + \
               "Nos vemos lá! 🎶\n" + \
               "Com amor, Sympla – Seu guia para eventos incríveis!"
    
    # Enviando apenas para os consumidores do gênero específico
    channel.basic_publish(exchange='topic-exchange',
                         routing_key=f'informacao.{genero}',
                         body=mensagem)
    print(f" [Mensagem de Mudança] Enviada -> <{mensagem}>")

def menu():
    while True:
        print("\n=== Menu de Opções ===")
        print("1. Enviar Mensagem de Novidade")
        print("2. Enviar Mensagem de Alerta")
        print("3. Enviar Mensagem de Mudança")
        print("4. Sair")
        
        opcao = input("\nEscolha uma opção (1-4): ")
        
        if opcao == '1':
            enviar_novidade()
        elif opcao == '2':
            enviar_alerta()
        elif opcao == '3':
            enviar_mudanca()
        elif opcao == '4':
            print("Encerrando o programa...")
            break
        else:
            print("Opção inválida! Tente novamente.")

if __name__ == "__main__":
    menu()
    connection.close()