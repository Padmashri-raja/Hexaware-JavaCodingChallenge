package dao;

import entity.Policy;
import util.DBConnUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InsuranceServiceImpl implements IPolicyService {

    private Connection connection;

    public InsuranceServiceImpl() {
        connection = DBConnUtil.getConnection();
    }

    @Override
    public boolean createPolicy(Policy policy) {
        String query = "INSERT INTO policy (policyId, policyNumber, policyType, coverageAmount, premium, startDate, endDate) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, policy.getPolicyId());
            stmt.setString(2, policy.getPolicyNumber());
            stmt.setString(3, policy.getPolicyType());
            stmt.setDouble(4, policy.getCoverageAmount());
            stmt.setDouble(5, policy.getPremium());
            stmt.setString(6, policy.getStartDate());
            stmt.setString(7, policy.getEndDate());

            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Error while creating policy: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Policy getPolicy(int policyId) {
        String query = "SELECT * FROM policy WHERE policyId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, policyId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Policy(
                    rs.getInt("policyId"),
                    rs.getString("policyNumber"),
                    rs.getString("policyType"),
                    rs.getDouble("coverageAmount"),
                    rs.getDouble("premium"),
                    rs.getString("startDate"),
                    rs.getString("endDate")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error while retrieving policy: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Policy> getAllPolicies() {
        List<Policy> policies = new ArrayList<>();
        String query = "SELECT * FROM policy";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Policy policy = new Policy(
                    rs.getInt("policyId"),
                    rs.getString("policyNumber"),
                    rs.getString("policyType"),
                    rs.getDouble("coverageAmount"),
                    rs.getDouble("premium"),
                    rs.getString("startDate"),
                    rs.getString("endDate")
                );
                policies.add(policy);
            }
        } catch (SQLException e) {
            System.out.println("Error while retrieving policies: " + e.getMessage());
        }
        return policies;
    }

    @Override
    public boolean updatePolicy(Policy policy) {
        String query = "UPDATE policy SET policyNumber=?, policyType=?, coverageAmount=?, premium=?, startDate=?, endDate=? WHERE policyId=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, policy.getPolicyNumber());
            stmt.setString(2, policy.getPolicyType());
            stmt.setDouble(3, policy.getCoverageAmount());
            stmt.setDouble(4, policy.getPremium());
            stmt.setString(5, policy.getStartDate());
            stmt.setString(6, policy.getEndDate());
            stmt.setInt(7, policy.getPolicyId());

            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Error while updating policy: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deletePolicy(int policyId) {
        String query = "DELETE FROM policy WHERE policyId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, policyId);
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            System.out.println("Error while deleting policy: " + e.getMessage());
            return false;
        }
    }
}
