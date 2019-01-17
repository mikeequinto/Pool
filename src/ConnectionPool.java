import java.util.ArrayList;


public class ConnectionPool {


    private ArrayList<Pair<Boolean,Connection>> lstConnection = new ArrayList<>();
    private PoolConfig poolConf;

    public ConnectionPool(PoolConfig poolConf)
    {
        this.poolConf = poolConf;
        for(int i = 0 ; poolConf.size>i ; i++)
        {
            lstConnection.add(new Pair<Boolean,Connection>(false,new Connection(i)));
        }
    }

    public Connection getConnection()
    {
        for(int i = 0 ; lstConnection.size()>i ; i++)
        {
            if(!lstConnection.get(i).getFirst()) {
                lstConnection.get(i).setFirst(true);
                return lstConnection.get(i).getSecond();
            }
        }
        return null;
    }

    public void releaseConnection(Connection connection)
    {
        lstConnection.get(connection.position).setFirst(false);
    }


    public ArrayList<Pair<Boolean, Connection>> getLstConnection() {
        return lstConnection;
    }

    public  PoolConfig getPoolConf() {
        return poolConf;
    }

}
