from rabbitmq_config import get_channel

def enviar_novidade():
    connection, channel = get_channel()

    nome_consumidor = input('Digite o nome do consumidor: ')
    nome_evento = input('Digite o nome do evento: ')
    data_evento = input('Digite a data do evento (DD/MM/AAAA): ')
    horario_evento = input('Digite o horário do evento (HH:MM): ')
    local_evento = input('Digite o local do evento: ')
    atracao_principal = input('Digite a atração principal: ')
    link_ingressos = input('Digite o link para compra de ingressos: ')
    
    mensagem = f"Olá {nome_consumidor}!\n\n" +                f"Temos uma novidade para você! Chegou o evento {nome_evento}!\n" +                f"Data: {data_evento}\n" +                f"Horário: {horario_evento}\n" +                f"Local: {local_evento}\n" +                f"Atração principal: {atracao_principal}\n\n" +                f"Ingressos disponíveis! Garanta o seu: {link_ingressos}\n\n" +                "Nos vemos lá! 🎶\n" +                "Com amor, [Nome da Empresa] – Seu guia para eventos incríveis!"
    
    channel.basic_publish(
        exchange='topic-exchange',
        routing_key='novidade',
        body=mensagem
    )

    print(f" [Mensagem de Novidade] Enviada -> <{mensagem}>")
    connection.close()