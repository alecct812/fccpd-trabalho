from rabbitmq_config import get_channel

def enviar_mudanca():
    connection, channel = get_channel()

    nome_consumidor = input('Digite o nome do consumidor: ')
    nome_evento = input('Digite o nome do evento: ')
    nova_data_evento = input('Digite a nova data do evento (DD/MM/AAAA): ')
    novo_horario_evento = input('Digite o novo horário do evento (HH:MM): ')
    local_evento = input('Digite o local do evento: ')
    genero = input('Digite o gênero do evento (rock/pop/rap): ').lower()

    mensagem = f"Olá {nome_consumidor}!\n\n" +                f"Atenção! O evento {nome_evento} sofreu uma alteração.\n" +                f"Nova Data: {nova_data_evento}\n" +                f"Novo Horário: {novo_horario_evento}\n" +                f"Local: {local_evento}\n\n" +                "Certifique-se de ajustar sua agenda!\n\n" +                "Nos vemos lá! 🎶\n" +                "Com amor, [Nome da Empresa] – Seu guia para eventos incríveis!"

    channel.basic_publish(
        exchange='topic-exchange',
        routing_key=f'mudanca.{genero}',
        body=mensagem
    )

    print(f" [Mensagem de Mudança] Enviada -> <{mensagem}>")
    connection.close()