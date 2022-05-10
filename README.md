# threeCoin

<details>
  <summary>
    <code>GET</code> 
    <code><b>/coin/list</b></code> 
    <code>(제외 코인 조회)</code>
  </summary>

##### Request

> | name   | Description      | Required |
> |--------|------------------|-----------|

##### Responses

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `index` |  Integer[]  | 강의ID 목록     | O |
> | `coinSym` |  varchar  | 코인 심볼     | O |
> | `coinName` |  varchar  | 코인 풀네임     | O |
> | `useYn` |  boolean  | 제외 여부     | O |

</details>

<details>
  <summary>
    <code>POST</code> 
    <code><b>/coin/hide</b></code> 
    <code>(제외 코인 등록, 삭제)</code>
  </summary>

##### Request

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `coinSym` |  varchar  | 코인 심볼     | O |
> | `coinName` |  varchar  | 코인 풀네임     | O |
  
##### Responses

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `index` |  Integer[]  | 강의ID 목록     | O |
> | `coinSym` |  varchar  | 코인 심볼     | O |
> | `coinName` |  varchar  | 코인 풀네임     | O |
> | `useYn` |  boolean  | 제외 여부     | O |

</details>

<details>
  <summary>
    <code>POST</code> 
    <code><b>/coin/hide</b></code> 
    <code>(제외 코인 삭제)</code>
  </summary>

##### Request

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `coinSym` |  varchar  | 코인 심볼     | O |
  
##### Responses

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|

</details>

<details>
  <summary>
    <code>POST</code> 
    <code><b>/coin/favorites</b></code> 
    <code>(관심 코인 조회)</code>
  </summary>

##### Request

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `userId` |  varchar  | 유저명     | O |

  
##### Responses

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `index` |  Integer[]  | 강의ID 목록     | O |
> | `userId` |  varchar  | 유저명     | O |
> | `coinSym` |  varchar  | 코인 심볼     | O |

</details>

<details>
  <summary>
    <code>POST</code> 
    <code><b>/coin/favorite</b></code> 
    <code>(관심 코인 등록 및 삭제)</code>
  </summary>

##### Request

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `userId` |  varchar  | 유저명     | O |
> | `coinSym` |  varchar  | 코인 심볼     | O |

  
##### Register Responses

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|
> | `index` |  Integer[]  | 강의ID 목록     | O |
> | `userId` |  varchar  | 유저명     | O |
> | `coinSym` |  varchar  | 코인 심볼     | O |
  
##### Delete Responses

> | name   |  type      | Description      | Required |
> |--------|------------|----------------|---|


</details>
