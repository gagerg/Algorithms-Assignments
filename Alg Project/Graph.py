class Graph(object):
    def __init__(self):
        self.adj_lst = []
        self.name_to_index = {}
        self.index_to_name = []
        self.cur_node_id = 0


    def user_exists(self, name):
        if name in self.name_to_index:
            return True
        else:
            return False


    def connection_exists(self, from_name, to_name):
        #make sure they both exist
        if self.user_exists(to_name) and self.user_exists(from_name):
            from_id = self.name_to_index[from_name]
            to_id = self.name_to_index[to_name]

            #get the edges coming from the from_name
            from_edges = self.adj_lst[from_id]
            #search the edges looking for the to_id
            edge_exists = False
            rating = None
            for i in range(1, len(from_edges)):
                if from_edges[i][0] == to_id:
                    edge_exists = True
                    rating = from_edges[i][1]
                    break

            if edge_exists:
                print('Connection from "%s" to "%s" has a rating of %i' %(from_name, to_name, rating))
            else:
                print('Connection from "%s" to "%s" does not exist' %(from_name, to_name))
            
        else:
            print('Either "%s" or "%s" or both do not exist' %(from_name, to_name))

    def add_edge(self, from_name, to_name, rating):
        #determine if the names exist in the graph already
        #if not add them
        if not self.user_exists(from_name):
            self.__add_node(from_name)
        if not self.user_exists(to_name):
            self.__add_node(to_name)

        #add an edge between them
        from_index = self.name_to_index[from_name]
        to_index = self.name_to_index[to_name]
        self.adj_lst[from_index].append([to_index, rating])

    
    def __add_node(self, name):
        #get the current node id
        node_id = self.cur_node_id
        self.cur_node_id += 1
        #add the node name to the dictionary
        self.name_to_index[name] = node_id
        #add to the index to name list
        self.index_to_name.append(name)
        #add to the adjacency list
        #entries in the adjacency list will look like:
        # [from_id, [to_id, rating]]
        self.adj_lst.append([node_id])



    
        


    