class PaymentStrategy:
    def pay(self, amount):
        pass

class CreditCardPayment(PaymentStrategy):
    def pay(self, amount):
        print(f"Pagando {amount} usando tarjeta de crédito.")

class PayPalPayment(PaymentStrategy):
    def pay(self, amount):
        print(f"Pagando {amount} usando PayPal.")

class Context:
    def __init__(self, strategy):
        self._strategy = strategy

    def set_strategy(self, strategy):
        self._strategy = strategy

    def execute_payment(self, amount):
        self._strategy.pay(amount)

# Uso del patrón
context = Context(CreditCardPayment())
context.execute_payment(100)

context.set_strategy(PayPalPayment())
context.execute_payment(150)
