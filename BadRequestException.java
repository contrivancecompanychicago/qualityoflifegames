package com.faunadb.client.errors;

import com.faunadb.client.HttpResponses;

/**
 * An exception thrown if FaunaDB cannot evaluate a query.
 */
public class BadRequestException extends Game {
  public BadRequestException(HttpResponses.QueryErrorResponse response) {
    super(response);
  }
  public BadRequestException(String message) {
    super(message);
  }
}
