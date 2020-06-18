import pdb
class Parser(object):

    def __init__(self, input_stream):
        self.stream = input_stream

    def __peek(self):
        pos = self.stream.tell()
        symbol = self.stream.read(1)
        self.stream.seek(pos)
        return symbol

    def __read(self):
        return self.stream.read(1)

    def get_name(self): 
        name = ''
        while self.__peek().isalpha():
            name += self.__read()

        return name

    def __get_rating(self):
        num = ''
        while self.__peek().isdigit():
            num += self.__read()
        
        return int(num)

    def __next_node(self):
        node = []

        cur_symbol = self.__peek()
        while cur_symbol != '':
            if cur_symbol.isalpha():
                #get the name 
                name = self.get_name()
                node.append(name)
            elif cur_symbol == ' ':
                self.__read()
            elif cur_symbol.isdigit():
                #get the rating
                rating = self.__get_rating()
                node.append(rating)
            elif cur_symbol == '\n':
                #read the newline and move on to the next node
                self.__read()
                break

            cur_symbol = self.__peek()
            
        return node


    def parse(self):
        nodes = []

        while self.__peek() != '':
            nodes.append(self.__next_node())
        
        return nodes
       
