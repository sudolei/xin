import request from '@/utils/request'

// 查询模板类型列表
export function listType(query) {
  return request({
    url: '/xin/type/list',
    method: 'get',
    params: query
  })
}

// 查询模板类型详细
export function getType(id) {
  return request({
    url: '/xin/type/' + id,
    method: 'get'
  })
}

// 新增模板类型
export function addType(data) {
  return request({
    url: '/xin/type',
    method: 'post',
    data: data
  })
}

// 修改模板类型
export function updateType(data) {
  return request({
    url: '/xin/type',
    method: 'put',
    data: data
  })
}

// 删除模板类型
export function delType(id) {
  return request({
    url: '/xin/type/' + id,
    method: 'delete'
  })
}
