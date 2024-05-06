import Ice
import sys
import CalculatorApp
import random


class CalculatorClient:
    def __init__(self):
        self.server_name = "CalculatorServer"
        self.communicator = Ice.initialize(sys.argv)
        basic1 = self.communicator.stringToProxy(f"Basic1/{self.server_name}:tcp -h 127.0.0.3 -p 10000 -z : udp -h 127.0.0.3 -p 10000 -z")
        basic2 = self.communicator.stringToProxy(f"Basic2/{self.server_name}:tcp -h 127.0.0.3 -p 10000 -z : udp -h 127.0.0.3 -p 10000 -z")
        self.basic_calculator1 = CalculatorApp.BasicCalculatorPrx.uncheckedCast(basic1)
        self.basic_calculator2 = CalculatorApp.BasicCalculatorPrx.uncheckedCast(basic2)
        extended1 = self.communicator.stringToProxy(f"Extended1/{self.server_name}:tcp -h 127.0.0.3 -p 10000 -z : udp -h 127.0.0.3 -p 10000 -z")
        extended2 = self.communicator.stringToProxy(f"Extended2/{self.server_name}:tcp -h 127.0.0.3 -p 10000 -z : udp -h 127.0.0.3 -p 10000 -z")
        self.extended_calculator1 = CalculatorApp.ExtendedCalculatorPrx.uncheckedCast(extended1)
        self.extended_calculator2 = CalculatorApp.ExtendedCalculatorPrx.uncheckedCast(extended2)
        scientific1 = self.communicator.stringToProxy(f"Scientific1/{self.server_name}:tcp -h 127.0.0.3 -p 10000 -z : udp -h 127.0.0.3 -p 10000 -z")
        scientific2 = self.communicator.stringToProxy(f"Scientific2/{self.server_name}:tcp -h 127.0.0.3 -p 10000 -z : udp -h 127.0.0.3 -p 10000 -z")
        self.scientific_calculator1 = CalculatorApp.ScientificCalculatorPrx.uncheckedCast(scientific1)
        self.scientific_calculator2 = CalculatorApp.ScientificCalculatorPrx.uncheckedCast(scientific2)
        trigonometric1 = self.communicator.stringToProxy(f"Trigonometric1/{self.server_name}:tcp -h 127.0.0.3 -p 10000 -z : udp -h 127.0.0.3 -p 10000 -z")
        trigonometric2 = self.communicator.stringToProxy(f"Trigonometric2/{self.server_name}:tcp -h 127.0.0.3 -p 10000 -z : udp -h 127.0.0.3 -p 10000 -z")
        self.trigonometric_calculator1 = CalculatorApp.TrygonometricCalculatorPrx.uncheckedCast(trigonometric1)
        self.trigonometric_calculator2 = CalculatorApp.TrygonometricCalculatorPrx.uncheckedCast(trigonometric2)

    def select_random_basic(self):
        n = random.randint(0, 1)
        print(f"Selected Basic{n + 1}")
        return self.basic_calculator1 if n == 0 else self.basic_calculator2

    def select_random_extended(self):
        n = random.randint(0, 1)
        print(f"Selected Extended{n + 1}")
        return self.extended_calculator1 if n == 0 else self.extended_calculator2

    def select_random_scientific(self):
        n = random.randint(0, 1)
        print(f"Selected Scientific{n + 1}")
        return self.scientific_calculator1 if n == 0 else self.scientific_calculator2

    def select_random_trigonometric(self):
        n = random.randint(0, 1)
        print(f"Selected Trigonometric{n + 1}")
        return self.trigonometric_calculator1 if n == 0 else self.trigonometric_calculator2

    def add(self, arguments):
        if len(arguments) != 2:
            print('Invalid number of arguments')
            return
        try:
            a = int(arguments[0])
            b = int(arguments[1])
            print(f"Result: {self.select_random_basic().add(a, b)}")
        except Exception as e:
            print(e)

    def subtract(self, arguments):
        if len(arguments) != 2:
            print('Invalid number of arguments')
            return
        try:
            a = int(arguments[0])
            b = int(arguments[1])
            print(f"Result: {self.select_random_basic().subtract(a, b)}")
        except Exception as e:
            print(e)

    def multiply(self, arguments):
        if len(arguments) != 2:
            print('Invalid number of arguments')
            return
        try:
            a = int(arguments[0])
            b = int(arguments[1])
            print(f"Result: {self.select_random_extended().multiply(a, b)}")
        except Exception as e:
            print(e)

    def divide(self, arguments):
        if len(arguments) != 2:
            print('Invalid number of arguments')
            return
        try:
            a = int(arguments[0])
            b = int(arguments[1])
            print(f"Result: {self.select_random_extended().divide(a, b)}")
        except Exception as e:
            print(e)

    def square_root(self, arguments):
        if len(arguments) != 1:
            print('Invalid number of arguments')
            return
        try:
            a = float(arguments[0])
            print(f"Result: {self.select_random_scientific().squareRoot(a)}")
        except Exception as e:
            print(e)

    def power(self, arguments):
        if len(arguments) != 2:
            print('Invalid number of arguments')
            return
        try:
            a = float(arguments[0])
            b = float(arguments[1])
            print(f"Result: {self.select_random_scientific().power(a, b)}")
        except Exception as e:
            print(e)

    def sin(self, arguments):
        if len(arguments) != 1:
            print('Invalid number of arguments')
            return
        try:
            a = float(arguments[0])
            print(f"Result: {self.select_random_trigonometric().sin(a)}")
        except Exception as e:
            print(e)

    def cos(self, arguments):
        if len(arguments) != 1:
            print('Invalid number of arguments')
            return
        try:
            a = float(arguments[0])
            print(f"Result: {self.select_random_trigonometric().cos(a)}")
        except Exception as e:
            print(e)

    def parse_command(self, command):
        command = command.split(' ')
        option = command[0]
        arguments = command[1:]
        if option == 'add':
            self.add(arguments)
        elif option == 'subtract':
            self.subtract(arguments)
        elif option == 'multiply':
            self.multiply(arguments)
        elif option == 'divide':
            self.divide(arguments)
        elif option == 'square':
            self.square_root(arguments)
        elif option == 'power':
            self.power(arguments)
        elif option == 'sin':
            self.sin(arguments)
        elif option == 'cos':
            self.cos(arguments)
        else:
            print('Unknown command')
        print()

    def run(self):
        while True:
            command = input('Enter command: ')
            if command == 'exit':
                break
            self.parse_command(command)
        self.communicator.shutdown()
        self.communicator.destroy()


if __name__ == "__main__":
    client = CalculatorClient()
    client.run()
