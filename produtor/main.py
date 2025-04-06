from novidade import enviar_novidade
from alerta import enviar_alerta
from mudanca import enviar_mudanca

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