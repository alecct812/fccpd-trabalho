from rabbitmq_config import get_channel

def enviar_alerta():
    connection, channel = get_channel()

    nome_consumidor = input('Digite o nome do consumidor: ')
    nome_evento = input('Digite o nome do evento: ')
    horas_restantes = input('Digite quantas horas faltam para o evento: ')
    data_evento = input('Digite a data do evento (DD/MM/AAAA): ')
    horario_evento = input('Digite o horário do evento (HH:MM): ')
    local_evento = input('Digite o local do evento: ')
    genero = input('Digite o gênero do evento (rock/pop/rap): ').lower()

    mensagem = f"Olá {nome_consumidor}!\n\n" +                f"Lembrete: o evento {nome_evento} começa em {horas_restantes} horas!\n" +                f"Data: {data_evento}\n" +                f"Horário: {horario_evento}\n" +                f"Local: {local_evento}\n\n" +                "Prepare-se para curtir esse evento incrível! 🎶\n" +                "Nos vemos lá!\n" +                "Com amor, [Nome da Empresa] – Seu guia para eventos incríveis!"

    channel.basic_publish(
        exchange='topic-exchange',
        routing_key=f'alerta.{genero}',
        body=mensagem
    )

    print(f" [Mensagem de Alerta] Enviada -> <{mensagem}>")
    connection.close()