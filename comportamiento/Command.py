class Command:
    def execute(self):
        pass

class AddTextCommand(Command):
    def __init__(self, editor, text):
        self.editor = editor
        self.text = text

    def execute(self):
        self.editor.add_text(self.text)

class TextEditor:
    def __init__(self):
        self.content = ""

    def add_text(self, text):
        self.content += text
        print(f"Content: {self.content}")

class Invoker:
    def __init__(self):
        self.history = []

    def execute_command(self, command):
        command.execute()
        self.history.append(command)

# Uso del patrón
editor = TextEditor()
invoker = Invoker()

command1 = AddTextCommand(editor, "Hola, ")
command2 = AddTextCommand(editor, "mundo!")

invoker.execute_command(command1)
invoker.execute_command(command2)
