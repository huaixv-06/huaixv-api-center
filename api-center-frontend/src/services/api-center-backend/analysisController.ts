// @ts-ignore
/* eslint-disable */
import { request } from '@umijs/max';

/** getListTopInvokeInterfaceInfo GET /api/analysis/top/interface/invoke */
export async function getListTopInvokeInterfaceInfoUsingGet(options?: { [key: string]: any }) {
  return request<API.BaseResponseListInterfaceInfoVO>('/api/analysis/top/interface/invoke', {
    method: 'GET',
    ...(options || {}),
  });
}
