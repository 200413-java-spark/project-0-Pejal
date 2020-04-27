package com.github.pejalrath;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SqlExchangeRepository {
    private SqlDataSource dataSource;
    private List<Data> history;

    public SqlExchangeRepository(SqlDataSource data)
    {
        this.dataSource=data;
        history=new ArrayList<>();
    }
    public void insertToDB(List<Data> data)
    {
        String sql_command="insert into data(input,total_coin,Quarter,Dime,Nickle,Penny) values(?,?,?,?,?,?)";
        try (Connection connection=this.dataSource.getConnection(); 
                PreparedStatement statement=connection.prepareStatement(sql_command);)
        {
            for(Data d:data)
            {
                statement.setDouble(1, d.getInput());
                statement.setInt(2, d.getQuarter());
                statement.setInt(3, d.getTotal());
                statement.setInt(4, d.getDime());
                statement.setInt(5, d.getNickle());
                statement.setInt(6, d.getPenny());
                statement.addBatch();
            }
            statement.executeBatch();

        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }
    public List<Data> readFromDB()
    {
        if (history.isEmpty())
        {
            String sql_command="select * from data";
            try(Connection connection=this.dataSource.getConnection();
                Statement statement=connection.createStatement();
                ResultSet rs=statement.executeQuery(sql_command);)
            {
                while(rs.next())
                {
                    Data data=new Data();
                    data.setInput(rs.getDouble("input"));
                    data.setTotal(rs.getInt("total_coin")); 
                    data.setQuarter(rs.getInt("Quarter"));
                    data.setDime(rs.getInt("Dime"));
                    data.setNickle(rs.getInt("Nickle"));
                    data.setPenny(rs.getInt("Penny"));
                    history.add(data);
                }

            }
            catch(SQLException e)
            {
                System.err.println(e.getMessage());
            }
            return history;

        }
        else
        {
            return history;
        }
    }




}

