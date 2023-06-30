// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package objectivitycommons.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.logging.ILogNode;
import com.mendix.systemwideinterfaces.MendixRuntimeException;
import com.mendix.systemwideinterfaces.javaactions.parameters.ITemplateParameter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Date;

/**
 * Executes the SQL statement, which must be an SQL Data Manipulation Language (DML) statement, such as INSERT, UPDATE or DELETE; or an SQL statement that returns nothing, such as a DDL statement.
 * 
 * Returns either the row count for SQL Data Manipulation Language (DML) statements or 0 for SQL statements that return nothing
 */
public class runSQL extends CustomJavaAction<java.lang.Long>
{
	private com.mendix.systemwideinterfaces.javaactions.parameters.IStringTemplate Sql;

	public runSQL(IContext context, com.mendix.systemwideinterfaces.javaactions.parameters.IStringTemplate Sql)
	{
		super(context);
		this.Sql = Sql;
	}

	@java.lang.Override
	public java.lang.Long executeAction() throws Exception
	{
		// BEGIN USER CODE
		logger.debug("executeAction: " + this.Sql);
		IContext ct = this.getContext();
        long resultList = 0;
        resultList = Core.dataStorage().executeWithConnection(connection ->
        {			
            try {
				
				// --- sql
				List<ITemplateParameter> pars = this.Sql.getParameters();
				String xp = this.Sql.replacePlaceholders((placeholder, idx) -> {
					ITemplateParameter par = pars.get(idx - 1);
					Object value = par.getValue();
					if (value == null) return "NULL";
					String val = value.toString();
					switch (par.getParameterType()) {
							case STRING: return String.format("'%s'", val.replace("'", "&apos;"));
							case BOOLEAN: return String.format("%s()", val);
							case DATETIME: return String.valueOf(((Date)value).getTime());
							default: return val;
						}
				});
				
				PreparedStatement stmt = connection.prepareStatement(xp);
                return stmt.executeUpdate();
            } 
			catch (SQLException e) {
                logger.error("Failed to execute sql statement: " + e.getMessage());
                throw new MendixRuntimeException(e);
            }
        });
        
		return resultList;

		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "runSQL";
	}

	// BEGIN EXTRA CODE
	private final ILogNode logger = Core.getLogger(this.getClass().getName());
	// END EXTRA CODE
}
