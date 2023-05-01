import { createConnection } from "./createconnection.js";
import { createApiDestination } from "./createApiDestination.js";
import { createRule } from "./createRule.js";
import { createTarget } from "./createTarget.js";

export const handler = async(registroRequest) => {

  console.log("## REGISTRO_REQUEST:", JSON.stringify(registroRequest, null, 2));   

  // Payload esperado de acordo com o OpenAPI do projeto : 
  // { "merchantId":"1234", "endpoint":"https://webhook.site/XXXX"}
  if(registroRequest == null || 
      registroRequest.merchantId == null || 
          registroRequest.endpoint == null) {
              throw new Error(`Dados inválidos: "${registroRequest}"`);
  }

  const merchantId = registroRequest.merchantId;
  const apiDestinationName = merchantId + "-apidestination";
  const ruleName = "Merchant-" + merchantId + "-rule";
  const endpoint = registroRequest.endpoint;

  const createConnectionInput = {
      connectionName: merchantId + "-conexao"
  };

  try { 
    
    const connectionData = await createConnection(createConnectionInput);
    console.log("Conexão status : ", (connectionData != null) ? "[SUCESSO]" : "[ERRO]");
    console.log("connectionData : ", connectionData);

    const createApiDestinationInput = {
        name: apiDestinationName,
        connectionArn: connectionData.ConnectionArn,
        endpoint: endpoint,
    };    
    
    const apiDestinationData = await createApiDestination(createApiDestinationInput);
    console.log("API Destination status : ", (apiDestinationData != null) ? "[SUCESSO]" : "[ERRO]"); 
    console.log("apiDestinationData : ", apiDestinationData);  

    const createRuleInput = {
        name: ruleName,
        merchantId: merchantId,
    };
      
    const ruleData = await createRule(createRuleInput);
    console.log("Rule status : ", (ruleData != null) ? "[SUCESSO]" : "[ERRO]");
    console.log("ruleData : ", ruleData);    

    const createTargetInput = {
        ruleName: ruleName,
        apiDestinationArn: apiDestinationData.ApiDestinationArn,
        apiDestinationName: apiDestinationName,
        merchantId: merchantId,
    };

    const targetData = await createTarget(createTargetInput);
    console.log("Target status : ", (targetData != null) ? "[SUCESSO]" : "[ERRO]");
    console.log("targetData : ", targetData);

    let response = {};

    if(connectionData != null && 
        apiDestinationData != null &&
          ruleData != null && 
            targetData != null) {

          response = {
            statusCode: 200,
            body: `Ativação do comerciante "${merchantId}" realizado com sucesso.`,            
          };
    } else {
      
      response = {
        statusCode: 500,
        body: `Erro inesperado na ativação do comerciante "${merchantId}"!!!`,
      };

    } 

    return response;

  } catch (err) {

    console.log("Error", err);

    const response = {
      statusCode: 500,
      body: `Erro inesperado na ativação do comerciante "${merchantId}"!!!`,
    };    

    return response;    
  }  
};